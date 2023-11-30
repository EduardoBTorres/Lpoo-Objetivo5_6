package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.salas;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class SalaController {
    private static final Scanner input = new Scanner(System.in);
    private static SalaService salaService;

    //Injeção de dependência
    public SalaController(SalaService salaService) {
        SalaController.salaService = salaService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU sala -------\"");
            System.out.print(
                    """
                                
                            1. Inserir novo sala
                            2. Atualizar uma sala
                            3. Excluir um cliente (tornar inativo)
                            4. Ativar ou Desativar um cliente
                            5. Listar todos os clientes
                            6. Buscar cliente pelo código
                            7. Buscar clientes pelo nome
                            8. Buscar clientes pela situação
                            Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> ativar();
                case 5 -> selectclientes();
                case 6 -> selectclientesById();
                case 7 -> selectclientesByNome();
                case 8 -> selectClientesBySituacao();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    //opção 1
    private static void inserir() {
        Sala sala = new Sala();
        System.out.println("\n++++++ Cadastro de nova Sala ++++++");
        System.out.print("Digite a capacidade da Sala: ");
        sala.setCapacidade(input.nextInt());
        System.out.print("\nDigite o número da sala: ");
        sala.setNrosala(input.nextInt());
        System.out.println("cliente salvo com sucesso:" + salaService.insert(sala));
    }

    //opção 2
    private static void atualizar() {
        System.out.println("\n++++++ Alterar um cliente ++++++");
    }

    private static void excluir() {
        System.out.println("\n++++++ Excluir um cliente ++++++");
    }

    private static void ativar() {
        System.out.println("\n++++++ Ativar/Desativar um cliente ++++++");
    }

    //opção 3
    private static void selectclientes() {
        System.out.println("\nLista de clientes cadastrados no banco de dados:\n");
    }

    //opção 4
    private static void selectclientesById() {
        System.out.print("\nDigite o código do cliente: ");
    }

    //opção 5
    private static void selectclientesByNome() {
        System.out.print("Digite o nome do cliente: ");
    }

    //opção 6
    private static void selectClientesBySituacao() {

    }

}//fim classe

