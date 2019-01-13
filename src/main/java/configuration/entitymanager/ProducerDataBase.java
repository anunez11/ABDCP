package configuration.entitymanager;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.gtdo.entitymanager.producer.DbApplication;



public class ProducerDataBase {
	
	/** La em. */
	@Produces
	@DbApplication
	@PersistenceContext(unitName = "ABDCP_DS")
	private EntityManager em;

	/**
	 * Instancia un nuevo producer data base.
	 */
	public ProducerDataBase() {
		// TODO Auto-generated constructor stub
	}

}
