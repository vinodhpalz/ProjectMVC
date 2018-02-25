package com.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO implements IProductDAO {
	private Transaction trans;
	private Session sess;
	private boolean b = true;
	/* (non-Javadoc)
	 * @see com.model.IProductDAO#insertProduct(com.model.Product)
	 */
	
	public boolean insertProduct(Product p) {
		try
		{
			DbConfig db = new DbConfig();
			sess = db.getSess();
			trans = sess.beginTransaction();
			sess.save(p);
			trans.commit();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			b = false;
		}
		return b;
	}
	
}
