package controller;

import model.Vendor;
import model.Vendor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class VendorHelper {
    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AnimalRescue");

    public void insertItem(Vendor vh){
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(vh);
        em.getTransaction().commit();
        em.close();
    }

    public List<Vendor> showAllItems(){
        EntityManager em = emfactory.createEntityManager();
        List<Vendor> allItems = em.createQuery("SELECT i FROM Vendor i").getResultList();
        return allItems;
    }

    public void deleteItem(Vendor toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Vendor> typedQuery = em.createQuery("select vh from Vendor vh where vh.vendorName = :selectedVendorName", Vendor.class);
        typedQuery.setParameter("selectedVendorName", toDelete.getVendorName());
        typedQuery.setMaxResults(1);
        Vendor result = typedQuery.getSingleResult();
        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public List<Vendor> searchForItemByVendorName(String vendorName) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Vendor> typedQuery = em.createQuery("select vh from Vendor vh where vh.vendorName = :selectedVendorName", Vendor.class);
        typedQuery.setParameter("selectedVendorName", vendorName);
        List<Vendor> foundItems = typedQuery.getResultList();
        em.close();
        return foundItems;
    }

    public Vendor searchForItemById(int idToEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        Vendor found = em.find(Vendor.class, idToEdit);
        em.close();
        return found;
    }

    public void updateItem(Vendor toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public void cleanUp(){
        emfactory.close();
    }
}