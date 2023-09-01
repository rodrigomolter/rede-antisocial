package cwi.antisocial.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cwi.antisocial.model.Instrutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@Transactional
public class InstrutorDaoTest {

	@Inject
	private InstrutorDao dao;
	
	@Test
	public void insereNovoInstrutor() throws Exception {
		Instrutor instrutor = new Instrutor();
		instrutor.setNome("FULANO DE TAL");
		instrutor = dao.salvar(instrutor);
		
		//Testa se a inserção ocorreu com sucesso
		assertNotNull(instrutor.getIdInstrutor());
		
		List<Instrutor> instrutores = dao.buscaPorNome("FULANO DE TAL");
		assertEquals(1, instrutores.size());
	}

	@Test
	public void atualizarInstrutor() throws Exception {
		Instrutor instrutor = new Instrutor();
		instrutor.setNome("FULANO DE TAL");
		instrutor = dao.salvar(instrutor);
		
		instrutor.setNome("BELTRANO");
		dao.salvar(instrutor);
		
		List<Instrutor> instrutores = dao.buscaPorNome("FULANO DE TAL");
		assertEquals(0, instrutores.size());
		
		instrutores = dao.buscaPorNome("BELTRANO");
		assertEquals(1, instrutores.size());
	}
	
	@Test
	public void excluirInstrutor() throws Exception {
		Instrutor instrutor = new Instrutor();
		instrutor.setNome("FULANO DE TAL");
		instrutor = dao.salvar(instrutor);
		
		dao.excluir(instrutor.getIdInstrutor());
		List<Instrutor> instrutores = dao.buscaPorNome("FULANO DE TAL");
		assertEquals(0, instrutores.size());
	}
}
