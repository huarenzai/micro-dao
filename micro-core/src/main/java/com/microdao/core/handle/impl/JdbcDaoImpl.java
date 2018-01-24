package com.microdao.core.handle.impl;

import com.microdao.common.exception.MicroException;
import com.microdao.common.util.ClassUtils;
import com.microdao.common.util.NameUtils;
import com.microdao.core.annotation.Column;
import com.microdao.core.annotation.Table;
import com.microdao.core.handle.JdbcDao;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * jdbc 操作入口
 * Created by fudh on 2018/1/24.
 */
public class JdbcDaoImpl extends AbstractJdbcDaoImpl implements JdbcDao {

//    public <T> T insert(Serializable entity) {
//        final StringBuilder sql=new StringBuilder("insert into ");
//        StringBuilder columsSql=new StringBuilder();
//        StringBuilder fieldSql=new StringBuilder();
//        final List<Object> params=new ArrayList<Object>();
//
//        Class<?> aClass = entity.getClass();
//        Table className = aClass.getAnnotation(Table.class);
//        if (null==className) {
//            throw new MicroException("没有使用table注解");
//        }
//        try {
//            String tableName = className.name();//表名
//            String pkField = className.pkField();
//            sql.append(tableName).append("(");
//            BeanInfo beanInfo = ClassUtils.getBeanInfo(entity.getClass());
//            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
//            for (PropertyDescriptor pd:pds) {
//                String name = pd.getName();
//                if (name.equals(pkField)) continue;
//
//                Field field = aClass.getDeclaredField(name);
//                Column fieldAnnotation = field.getAnnotation(Column.class);
//                String fieldName = name;
//                if (null==fieldAnnotation){
//                    fieldName= NameUtils.getColumNameByFiled(fieldName);
//                }else {
//                    fieldName=fieldAnnotation.name();
//                }
//                Method readMethod = pd.getReadMethod();
//                Object value = readMethod.invoke(entity);
//                if (value==null) continue;
//                columsSql.append(fieldName).append(",");
//                fieldSql.append("?").append(",");
//                params.add(value);
//            }
//            columsSql.deleteCharAt(columsSql.length()-1);
//            fieldSql.deleteCharAt(fieldSql.length()-1);
//            sql.append(columsSql).append(")values(").append(fieldSql).append(")");
//            return (T) (Integer)this.jdbcTemplate.update(new PreparedStatementCreator() {
//                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                    PreparedStatement ps = connection
//                            .prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
//                    ArgumentPreparedStatementSetter pss = new ArgumentPreparedStatementSetter(params.toArray());
//                    pss.setValues(ps);
//                    return ps;
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 插入数据
     * @param obj
     */
    public void insert(Object obj) {
        final StringBuilder sql=new StringBuilder("insert into ");
        StringBuilder columsql=new StringBuilder();
        StringBuilder fieldSql=new StringBuilder();
        final List<Object> params=new ArrayList<Object>();
        try {
            //反射
            Class<?> aClass = obj.getClass();
            Table tableAnno = aClass.getAnnotation(Table.class);
            if (null == tableAnno) {
                throw new MicroException("没有table注解");
            }
            String tableName = tableAnno.name();//表名
            String pkField = tableAnno.pkField();//主键
            sql.append(tableName).append("(");

            BeanInfo beanInfo = ClassUtils.getBeanInfo(aClass);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                String fieldName = pd.getName();
                if (fieldName.equals(pkField)) continue;
                Method readMethod = pd.getReadMethod();
                Object val = readMethod.invoke(obj);//数据
                if (val==null) continue;
                columsql.append(fieldName).append(",");
                fieldSql.append("?,");
                params.add(val);

            }
            columsql.deleteCharAt(columsql.length()-1);
            fieldSql.deleteCharAt(fieldSql.length()-1);
            sql.append(columsql).append(")values(").append(fieldSql).append(")");
            System.out.println(sql);
            System.out.println(params);
            this.jdbcTemplate.update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                    ArgumentPreparedStatementSetter pss = new ArgumentPreparedStatementSetter(params.toArray());
                    pss.setValues(ps);
                    return ps;
                }
            });
        }catch (Exception e){

        }
    }
}
