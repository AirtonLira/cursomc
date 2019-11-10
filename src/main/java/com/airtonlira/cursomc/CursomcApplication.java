package com.airtonlira.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.airtonlira.cursomc.domain.Categoria;
import com.airtonlira.cursomc.domain.Cidade;
import com.airtonlira.cursomc.domain.Cliente;
import com.airtonlira.cursomc.domain.Endereco;
import com.airtonlira.cursomc.domain.Estado;
import com.airtonlira.cursomc.domain.Produto;
import com.airtonlira.cursomc.domain.enums.TipoCliente;
import com.airtonlira.cursomc.repositories.CategoriaRepository;
import com.airtonlira.cursomc.repositories.CidadeRepository;
import com.airtonlira.cursomc.repositories.ClienteRepository;
import com.airtonlira.cursomc.repositories.EnderecoRepository;
import com.airtonlira.cursomc.repositories.EstadoRepository;
import com.airtonlira.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 200.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		/*Cidade e estado*/
		
		Estado est1 = new Estado(null, "Minas gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		/*cliente*/
		
		Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com","321321312",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("322115555","2332441123"));
		
		/*Enderecos*/
		Endereco e1 = new Endereco(null, "rua null","300","Apto 303","jardim","13123123",cli1,c1);
		Endereco e2 = new Endereco(null, "rua null2","3002","Apto 3032","Centro","13123123",cli1,c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}

}
