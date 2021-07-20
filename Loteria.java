package Loteria;

//Importação das bibliotecas necessárias para o projeto
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loteria {

	public static void main(String[] args) throws IOException {

		// Chamada da função que executa a leitura do arquivo.
		leArquivo();
	}

	static void leArquivo() {

		// Busca o arquivo no diretório e faz a leitura.
		File arquivo = new File("C:\\Users\\William\\Documents\\Sorteios.txt");

		try {

			FileReader leitura = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(leitura);

			// Declarações de variáveis.
			String tabela = "";
			// Variavel temp para receber, temporariamente, o valor da posição[i].
			int temp = 0;
			// Variavel que receberá o valor convertido das Strings do arquivo.
			int num = 0;

			int[] numeros = new int[60];
			int[] freq = new int[60];

			// Preenchimento do vetor Numeros.
			for (int i = 0; i < numeros.length; i++) {
				freq[i] = 0;
				numeros[i] = i + 1;
			}
			// Formatação do arquivo.
			while ((tabela = br.readLine()) != null) {
				String[] linha = tabela.split("-");

				// Conversão dos dados String para Inteiros e incremento de frequência.
				for (int i = 0; i < linha.length; i++) {

					num = Integer.parseInt(linha[i]);
					freq[num - 1] += 1;

				}
			}

			// Fecha o arquivo e encerra a leitura do arquivo.
			leitura.close();
			br.close();

			// Ordenação de vetor usando BubbleSort
			for (int i = 0; i < freq.length; i++) {
				for (int j = 0; j < (freq.length - 1); j++) {
					// Condição para ordenação crescente.
					if (freq[j] < freq[j + 1]) {

						// Ordenação de vetor de Frequencia
						temp = freq[j];
						freq[j] = freq[j + 1];
						freq[j + 1] = temp;

						// Ordenação de vetor de Numeros
						temp = numeros[j];
						numeros[j] = numeros[j + 1];
						numeros[j + 1] = temp;
					}
				}
			}
									
			// Impressão do resultado da ordenação.
			System.out.println("=-=-=-=-=-=-=- SORTEIO MEGA SENA -=-=-=-=-=-=-=");
			System.out.println("");
			System.out.println("Os 6 números MAIS sorteados desde 1996 foram:");
			System.out.println("");
			for (int i = 0; i < 6; i++) {

				System.out.println("O numero:" + numeros[i] + " apareceu:" + freq[i]);

			}
			System.out.println("");
			System.out.println("=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			


			// Impressão de mensagem de erro.
		} catch (Exception e) {
			System.out.println("Erro na leitura");
		}
	}
}