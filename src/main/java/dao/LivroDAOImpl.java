package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Livro;
import util.JpaUtil;

public class LivroDAOImpl implements LivroDAO {
	
	
	
	public void inserir(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();	
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(livro);
		tx.commit();
		
		ent.close();
	
	}
	
	/**
	 * Metodo alterar, recebe Livro, criar uma transição, inicia e executa a ação de merge
	 */
	
	public void  alterar(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(livro);
		tx.commit();
		
		ent.close();
	}
	
	public void remover(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(livro);
		tx.commit();
		
		ent.close();
	}
	
	/**
	 * pesquisar pela chave primaria que seria o codigo
	 */
	
	public Livro pesquisar(String codigo) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Livro livro = ent.find(Livro.class, codigo);
		
		return livro;
	}
	
	/**
	 * O metodo listar todos, faz um select * from, com o JPA a consulta é pelo objeto direto
	 * 
	 */
	
	public List<Livro> listarTodos(){
		
		EntityManager ent = JpaUtil.getEntityManager();
		Query query = ent.createQuery("from Livro l");
		
		List<Livro> livros = query.getResultList();
		
		return livros;
		
	}
	
	
	


}
