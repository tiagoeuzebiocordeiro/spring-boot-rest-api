package curso.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*Essa anotação vai rodar o projeto...*/
@SpringBootApplication
@EntityScan(basePackages = {"curso.api.rest.model"}) /*Essa outra anotação vai pegar o pacote e ler as tabelas, criando-as automaticamente*/
@ComponentScan(basePackages = {"curso.*"}) /*Lendo e configurando o projeto...*/
@EnableJpaRepositories(basePackages = {"curso.api.rest.repository"}) /*Habilitar a parte de repositorios e persistencia JPA na pasta escolhida*/
@EnableTransactionManagement /*Gerencia(Manager) de transações, não enfrentar problemas de transações no banco de dados*/
@EnableWebMvc /*Ativando o recurso MVC, mas vou trabalhar com REST*/
@RestController /*Controlador... retorno de json*/
@EnableAutoConfiguration /*Auto Configuration automatico*/
public class CursospringrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursospringrestapiApplication.class, args);
	}

}
