package br.com.senac.initializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Cidade;
import br.com.senac.dominio.Endereco;
import br.com.senac.dominio.Estado;
import br.com.senac.repositorio.AlunoRepositorio;
import br.com.senac.repositorio.CidadeRepositorio;
import br.com.senac.repositorio.EnderecoRepositorio;
import br.com.senac.repositorio.EstadoRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired //controle/inversao de dependencia- qnd eu preciso ele cria um objeto para mim
	CidadeRepositorio cidadeRepositorio;
	@Autowired //controle/inversao de dependencia- qnd eu preciso ele cria um objeto para mim
	AlunoRepositorio alunoRepositorio;
	@Autowired //controle/inversao de dependencia- qnd eu preciso ele cria um objeto para mim
	EstadoRepositorio estadoRepositorio;
	@Autowired
	EnderecoRepositorio enderecoRepositorio;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1= new Aluno();
		aluno1.setNome("Lucas");
		aluno1.setEmail("lucas@gmail.com");
		alunoRepositorio.save(aluno1);
		
		Aluno alunoGravado = alunoRepositorio.findByEmail("lucas@gmail.com");
		
		Estado estado1= new Estado();
		estado1.setNome("Rio de Janeiro");
		
		Estado estado2= new Estado();
		estado1.setNome("São Paulo");
		
		Cidade cidade1= new Cidade();
		cidade1.setNome("Angra dos reis");
		cidade1.setEstado(estado1);
		
		Cidade cidade2= new Cidade();
		cidade2.setNome("Cabo Frio");
		cidade2.setEstado(estado1);
		
		Cidade cidade3= new Cidade();
		cidade3.setNome("Mogi das Cruzes");
		cidade3.setEstado(estado2);
		
		estadoRepositorio.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepositorio.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Endereco end1=new Endereco();
		end1.setRua("Rua dos Andradas");
		end1.setNumero("20");
		end1.setBairro("Centro");
		end1.setComplemento("Bloco B");
		end1.setCep("22210-065");
		end1.setCidade(cidade1);
		end1.setAluno(aluno1);
		
		Endereco end2=new Endereco();
		end1.setRua("Rua dos Marrecos");
		end1.setNumero("68");
		end1.setBairro("Lapa");
		end1.setComplemento("Bloco C");
		end1.setCep("22211-065");
		end1.setCidade(cidade2);
		end1.setAluno(aluno1);
		
		aluno1.getTelefones().addAll(Arrays.asList("123456","654321"));
		
		alunoRepositorio.save(aluno1);
		
		enderecoRepositorio.saveAll(Arrays.asList(end1,end2));
		
	}

}
