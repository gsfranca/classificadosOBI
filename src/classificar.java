import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class classificar
{
    public void classificarOBI(String ent, String sai)
    {
        // Declaração da entradas
        File entrada = new File(ent);

        // Declaração da arrayslist que guardara os numeros
        ArrayList e = new ArrayList();

        // Declaração do scanner
        Scanner sc = null;

        // Tenta ler o arquivo (que precisa ta dentro de um try catch pra funcionar)
        try
        {
            sc = new Scanner(entrada);

            // Transfere os dados do arquivo para a arraylist
            while (sc.hasNextLine())
            {
                e.add(sc.nextLine());
            }

            // Quantidade de participantes e vagas
            int eParticipantes = Integer.parseInt(e.get(0).toString());
            int eVagas =  Integer.parseInt(e.get(1).toString());

            // Exclui esses numeros da array
            e.remove(0);
            e.remove(0);

            // Ordena em ordem decrescente
            Collections.sort(e, Collections.reverseOrder());

            // Calcula o número de competidores classificados
            int classificados = eVagas;
            int pontuacaoMinima = Integer.parseInt(e.get(eVagas - 1).toString());

            // Se algum proximo numero for igual a portuação minima
            for (int i = eVagas; i < e.size(); i++)
            {
                if (Integer.parseInt(e.get(i).toString()) == pontuacaoMinima)
                {
                    classificados++;
                }
                else
                {
                    break;
                }
            }

            // Salva o número de competidores classificados na saida
            PrintWriter ps = new PrintWriter(sai);

            ps.print("Número de classificados: " + classificados);
            ps.close();

            System.out.println("Abra o arquivo " + sai + " para vertificar o número de classificados");
        }

        catch (IOException erro)
        {
            System.out.println("Error: " + erro.getMessage());
        }
        finally
        {
            if (sc != null)
            {
                sc.close();
            }
        }
    }
}
