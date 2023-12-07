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
                            3. Excluir uma sala
                            4. Listar todos os clientes
                            5. Buscar sala pelo código
                            6. Buscar sala pela capacidade
                            Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectsala();
                case 5 -> selectsalaById();
                case 6 -> selectsalaByCapacidade();
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
        System.out.println("\n++++++ Alterar uma sala ++++++");
        Sala sala;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da sala (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                sala = salaService.getSalaById(codigo);
                if (sala == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Número da Sala: " + sala.getNrosala());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo número da sala: ");
                        sala.setNrosala(input.nextInt());
                    }
                    System.out.println("Capacidade: " + sala.getCapacidade());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        //input.nextLine();
                        System.out.print("Digite uma nova capacidade para a sala: ");
                        sala.setCapacidade(input.nextInt());
                    }
                    System.out.println(sala);
                    if(salaService.update(sala) != null) {
                        System.out.println("cliente atualizado com sucesso. " + salaService.getSalaById(sala.getId()));
                    } else {
                        System.out.println("Não foi possível atualizar este cliente. Por favor, contate o administrador.");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static void excluir() {
        System.out.println("\n++++++ Excluir uma sala ++++++");
        Sala sala;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da sala (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                sala = salaService.getSalaById(codigo);
                if (sala == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(sala);
                    System.out.print("Excluir este cliente? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        salaService.delete(sala.getId());
                        System.out.println("sala excluída com sucesso:" + sala);
                    }
                }
            } else {
                System.out.println("Digite um id válido!!!");
            }
        } while (opcao != 0);
    }

    //opção 3
    private static void selectsala() {
        System.out.println("\nLista de clientes cadastrados no banco de dados:\n" + salaService.getSala());
    }

    //opção 4
    private static void selectsalaById() {
        System.out.print("\nDigite o código do cliente: ");
        Sala sala = salaService.getSalaById(input.nextLong());
        input.nextLine();
        if (sala != null) {
            System.out.println(sala);
        } else {
            System.out.println("Código não localizado.");
        }
    }

    //opção 6
    private static void selectsalaByCapacidade() {
        System.out.print("Digite a capacidade da sala: ");
        Integer capacidade = input.nextInt();
        System.out.println("Chave de pesquisa: " + capacidade);
        List<Sala> sala = salaService.getSalaByCapacidade(capacidade);
        if (sala.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + capacidade);
        } else {
            System.out.println(sala);
        }
    }

}//fim classe

