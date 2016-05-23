package hogm.jpa.ejb;

import hogm.jpa.entities.LuckyNumberEntity;

import java.util.Random;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@Named("bean")
public class CMTBean {

	private static final Logger log = Logger.getLogger(CMTBean.class.getName());
	
    @PersistenceContext(unitName = "HOGM_JPA_JBOSSAS_PU")
    private EntityManager em;

    public void persistAction() {
    	log.info("Persisting LuckyNumberEntity instance ...");
        LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
        luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));
        em.persist(luckyNumberEntity);
        log.info("Persist successful ...");
    }
}
