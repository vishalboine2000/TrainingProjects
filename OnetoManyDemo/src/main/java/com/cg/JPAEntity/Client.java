package com.cg.JPAEntity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

 

public class Client {
    
    public static void main(String [] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test2");
        EntityManager em = emf.createEntityManager();
    //    EntityTransaction transaction = em.getTransaction();
        em.getTransaction().begin();
        
        Items items = new Items();
        items.setItemId("laptop");
        items.setItemTotal(3400.50);
        items.setQuantity(5);
        
        Items items1 = new Items();
        items1.setItemId("mouse");
        items1.setItemTotal(5000.50);
        items1.setQuantity(10);
        
        em.persist(items);
        em.persist(items1);
        
            
        Set <Items> set1 = new HashSet<Items>();
        set1.add(items);
        set1.add(items1);
        
        
        Cart cart1 = new Cart();
        cart1.setName("C1200");
        cart1.setTotal(34000.00);
        cart1.setItems(set1);
        
        
        em.persist(cart1);
        em.getTransaction().commit();
        em.close();
        
    }
}
