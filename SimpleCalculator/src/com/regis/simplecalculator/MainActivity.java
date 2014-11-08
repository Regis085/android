package com.regis.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText visor;
	private String numeroAtual = "";
	private String numeroArmazenado = "";
	private int operacaoAtual;
	private boolean emOperacao;
	private boolean operacaoUnica = true;
	private boolean igualPressionado;
	private String operacaoArmazenada = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		visor = (EditText) findViewById(R.id.visor);
	}

	public void numero_click(View v) {
		String numeroClicado;

		// situação onde clica-se em um número após ter se clicado no botão
		// igual.
		if (igualPressionado) {
			zerarMemoria();
			limparVisor();
			igualPressionado = false;
		}

		if (emOperacao) {
			limparVisor();
			emOperacao = false;
		}

		// Capturando número do botão clicado
		numeroClicado = ((Button) v).getText().toString();

		// concatenando número ao numeroAtual
		numeroAtual = numeroAtual + numeroClicado;

		// atualiza o visor com este número
		visor.setText(numeroAtual);

		// Log.i("jrn", "Valor capturado: " + texto);
		// Log.i("jrn", "Acumulado " + numDigitado);

	}

	public void clear_click(View v) {
		limparVisor();
		zerarMemoria();
	}

	public void operacao_click(View v) {
		String operacaoClicada = ((Button) v).getText().toString();
		if (operacaoArmazenada.equals("")) {
			if (operacaoUnica) {

				if (operacaoClicada.equals("+")) {
					operacaoAtual = 1;
				} else if (operacaoClicada.equals("-")) {
					operacaoAtual = 2;
				} else if (operacaoClicada.equals("*")) {
					operacaoAtual = 3;
				} else if (operacaoClicada.equals("/")) {
					operacaoAtual = 4;
				}
				numeroArmazenado = numeroAtual;
				numeroAtual = "";
				emOperacao = true;
				operacaoUnica = false;
			} else {
				calcular();
				numeroArmazenado = visor.getText().toString();
				numeroAtual = "";
				emOperacao = true;

				if (operacaoClicada.equals("+")) {
					operacaoAtual = 1;
				} else if (operacaoClicada.equals("-")) {
					operacaoAtual = 2;
				} else if (operacaoClicada.equals("*")) {
					operacaoAtual = 3;
				} else if (operacaoClicada.equals("/")) {
					operacaoAtual = 4;
				}
			}
			operacaoArmazenada = operacaoClicada;
		}
		else{
			calcular();
			
			
		}
	}

	public void resultado_click(View v) {
		calcular();
		igualPressionado = true;
	}

	private void calcular() {
		/*
		 * Calcula e mostra resultado na tela.
		 */
		if (!numeroAtual.equals("") && !numeroArmazenado.equals("")) {
			String resultado;
			switch (operacaoAtual) {
			case 1:
				resultado = Operacoes.somar(numeroArmazenado, numeroAtual);
				numeroArmazenado = resultado;
				visor.setText(resultado);
				break;
			case 2:
				resultado = Operacoes.subtrair(numeroArmazenado, numeroAtual);
				numeroArmazenado = resultado;
				visor.setText(resultado);
				break;
			case 3:
				resultado = Operacoes
						.multiplicar(numeroArmazenado, numeroAtual);
				numeroArmazenado = resultado;
				visor.setText(resultado);
				break;
			case 4:
				resultado = Operacoes.dividir(numeroArmazenado, numeroAtual);
				numeroArmazenado = resultado;
				visor.setText(resultado);
				break;
			}
		}
	}

	private void limparVisor() {
		visor.setText("");
		operacaoUnica = true;
		operacaoArmazenada = "";
	}

	private void zerarMemoria() {
		numeroArmazenado = numeroAtual = "";
	}
}
