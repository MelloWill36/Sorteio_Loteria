package Loteria;

//Importa��o das bibliotecas necess�rias para o projeto
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loteria {

	public static void main(String[] args) throws IOException {

		// Chamada da fun��o que executa a leitura do arquivo.
		leArquivo();
	}

	static void leArquivo() {

		// Busca o arquivo no diret�rio e faz a leitura.
		File arquivo = new File("C:\\Users\\William\\Documents\\Sorteios.txt");

		try {

			FileReader leitura = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(leitura);

			// Declara��es de vari�veis.
			String tabela = "";
			// Variavel temp para receber, temporariamente, o valor da posi��o[i].
			int temp = 0;
			// Variavel que receber� o valor convertido das Strings do arquivo.
			int num = 0;

			int[] numeros = new int[60];
			int[] freq = new int[60];

			// Preenchimento do vetor Numeros.
			for (int i = 0; i < numeros.length; i++) {
				freq[i] = 0;
				numeros[i] = i + 1;
			}
			// Formata��o do arquivo.
			while ((tabela = br.readLine()) != null) {
				String[] linha = tabela.split("-");

				// Convers�o dos dados String para Inteiros e incremento de frequ�ncia.
				for (int i = 0; i < linha.length; i++) {

					num = Integer.parseInt(linha[i]);
					freq[num - 1] += 1;

				}
			}

			// Fecha o arquivo e encerra a leitura do arquivo.
			leitura.close();
			br.close();

			// Ordena��o de vetor usando BubbleSort
			for (int i = 0; i < freq.length; i++) {
				for (int j = 0; j < (freq.length - 1); j++) {
					// Condi��o para ordena��o crescente.
					if (freq[j] < freq[j + 1]) {

						// Ordena��o de vetor de Frequencia
						temp = freq[j];
						freq[j] = freq[j + 1];
						freq[j + 1] = temp;

						// Ordena��o de vetor de Numeros
						temp = numeros[j];
						numeros[j] = numeros[j + 1];
						numeros[j + 1] = temp;
					}
				}
			}
									
			// Impress�o do resultado da ordena��o.
			System.out.println("=-=-=-=-=-=-=- SORTEIO MEGA SENA -=-=-=-=-=-=-=");
			System.out.println("");
			System.out.println("Os 6 n�meros MAIS sorteados desde 1996 foram:");
			System.out.println("");
			for (int i = 0; i < 6; i++) {

				System.out.println("O numero:" + numeros[i] + " apareceu:" + freq[i]);

			}
			System.out.println("");
			System.out.println("=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			


			// Impress�o de mensagem de erro.
		} catch (Exception e) {
			System.out.println("Erro na leitura");
		}
	}
}