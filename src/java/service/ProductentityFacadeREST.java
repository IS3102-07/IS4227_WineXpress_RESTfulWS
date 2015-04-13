/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entity.Lineitementity;
import Entity.Memberentity;
import Entity.Productentity;
import Entity.Shoppingcartentity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author admin
 */
@Stateless
@Path("product")
public class ProductentityFacadeREST extends AbstractFacade<Productentity> {

    @PersistenceContext(unitName = "WineXpress_RESTfulPU")
    private EntityManager em;

    public ProductentityFacadeREST() {
        super(Productentity.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Productentity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Productentity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Productentity find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Productentity> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Productentity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("getAllProducts")
    @Produces("application/json")
    public List<Productentity> getAllProducts() {
        Query q = em.createQuery("Select p from Productentity p where p.isdeleted=FALSE");
        List<Productentity> list = (List<Productentity>) q.getResultList();
        return list;
    }

    @GET
    @Path("getProductNameBySKU")
    @Produces("application/json")
    public String getProductNameBySKU(@QueryParam("SKU") String SKU) {
        try {
            Query q = em.createQuery("Select p from Productentity p where p.isdeleted=FALSE and p.sku=:SKU");
            q.setParameter("SKU", SKU);
            Productentity p = (Productentity) q.getSingleResult();
            return p.getName();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @GET
    @Path("uploadShoppingCart")
    @Produces("application/json")
    public String uploadShoppingCart(@QueryParam("email") String email, @QueryParam("shoppingList") String shoppingList) {
        try {
            Query q = em.createQuery("SELECT m FROM Memberentity m where m.email=:email and m.isdeleted=FALSE");
            q.setParameter("email", email);
            Memberentity m = (Memberentity) q.getSingleResult();
            Shoppingcartentity shoppingCart = m.getShoppingcartentityId();
            Scanner sc = new Scanner(shoppingList);
            Productentity p = null;
            sc.useDelimiter(",");
            List<Lineitementity> lineItemList = new ArrayList<>();
            while (sc.hasNext()) {
                String sku = sc.next();
                int quantity = sc.nextInt();
                System.out.println("huat  0 " + sku + quantity);

                Query qq = em.createQuery("SELECT p FROM Productentity p where p.sku=:sku and p.isdeleted=FALSE");
                qq.setParameter("sku", sku);
                p = (Productentity) qq.getSingleResult();
                System.out.println("huat 1 " + p.getSku());
                Lineitementity lineItem = new Lineitementity();
                em.persist(lineItem);
                em.flush();
                lineItem.setQuantity(quantity);
                lineItem.setProductentityId(p);
                //em.refresh(lineItem);
                lineItemList.add(lineItem);

                em.flush();
                System.out.println("huat 3");
            }
            shoppingCart.setLineitementityList(lineItemList);
            //em.merge(shoppingCart);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
