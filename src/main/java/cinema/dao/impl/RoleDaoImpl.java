package cinema.dao.impl;

import java.util.Optional;
import cinema.dao.RoleDao;
import cinema.model.Role;
import cinema.dao.AbstractDao;
import cinema.exception.DataProcessingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> getByName = session.createQuery(
                    "FROM Role WHERE roleName = :roleName", Role.class);
            getByName.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return getByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Cant get role with name "
                    + roleName + " from db", e);
        }
    }
}
