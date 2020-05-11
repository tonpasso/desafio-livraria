package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;
import util.JpaUtil;



public class UsuarioDAOImpl implements UsuarioDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
	 * executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Usuario usuario) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(usuario);
		
		tx.commit();
		ent.close();

	}

	public void alterar(Usuario usuario) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(usuario);
		
		tx.commit();
		ent.close();

	}


	public void remover(Usuario usuario) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(usuario);
		
		tx.commit();
		ent.close();
		
	}


	public Usuario pesquisar(String cpf) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Usuario usuario = ent.find(Usuario.class, cpf);
		
		return usuario;
		
	}


	public List<Usuario> listarTodos() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Usuario u");
		
		List<Usuario> usuarios = query.getResultList();
	
		return usuarios;
		
	}
	
	
	
}
