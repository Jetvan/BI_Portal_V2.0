package com.analytic.portal.module.system.dao.impl;

import java.util.List;
import java.util.Map;

import com.analytic.portal.common.sys.GlobalConstants;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.analytic.portal.module.common.dao.impl.BaseDaoImp;
import com.analytic.portal.module.common.util.FieldNameUtil;
import com.analytic.portal.module.system.dao.interfaces.SysUserRoleDao;
import com.analytic.portal.module.system.model.SysRoleMenu;
import com.analytic.portal.module.system.model.SysUserRole;

@Repository("sysUserRoleDao")
public class SysUserRoleDaoImpl extends BaseDaoImp implements SysUserRoleDao {

	@Override
	public List<SysUserRole> getSysUserRoleList(Map paraMap) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SysUserRole.class);
		List<String> fieldRoleId = FieldNameUtil.getFieldNames(SysUserRole.class);
		for (Object key : paraMap.keySet()) {
			 Object value = paraMap.get(key);
			 if (fieldRoleId.contains(key) && (value != null && !value.equals(""))) {
					criteria.add(Restrictions.eq((String)key, value));
				}
		}
		return super.getHibernateTemplates().findByCriteria(criteria);
	}
	
	@Override
	public boolean deleteSysUserRoleUserId(String userId) throws Exception {
		String hql = "delete From SysUserRole s where s.userId = "+userId;
		return super.updateByHql(hql);
	}

	@Override
	public void deleteSysUserRoleByRoleType(String userId,String roleType) throws Exception {
//		String hql = "delete From SysUserRole s where  s.userId = "+userId;
//		String hql = "delete from sys_user_role s where  s.user_id = "+userId+" and s.role_id in (select r.id from (select id from sys_role where role_status=1 and is_delete=0 and role_type="+roleType+" and id in (select role_id from sys_user_role where user_id="+userId+"))r)";
		String hql = "delete from sys_user_role  where  user_id = '"+userId+"' and role_id in (select r.id from  (select id from sys_role where role_status='1' and is_delete='0' and role_type='"+roleType+"' and  id in (select role_id from sys_user_role where user_id='"+userId+"'))r)";
		Query sqlQuery =super.getSession().createSQLQuery(hql);
		sqlQuery.executeUpdate();
//		return super.updateByHql(hql);

	}

	@Override
	public boolean deleteRepeortUserMapping(String userId) throws Exception {
		String hql = "delete From ReportUserMapping s where s.userId = "+userId;
		return super.updateByHql(hql);
	}
}
