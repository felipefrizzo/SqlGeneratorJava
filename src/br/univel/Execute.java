package br.univel;

import br.univel.annotation.Column;
import br.univel.annotation.Table;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;

/**
 * Created by felipefrizzo on 4/20/16.
 */
public class Execute extends SqlGenerator {
    public Execute() {
    }

    @Override
    protected String getCreateTable(Object obj) {
        try {
            String nameTable;
            Class<?> cl = obj.getClass();

            StringBuilder sb = new StringBuilder();

            if (cl.isAnnotationPresent(Table.class)) {
                Table annotationTable = cl.getAnnotation(Table.class);
                nameTable = annotationTable.value();
            } else {
                nameTable = cl.getSimpleName().toUpperCase();
            }
            sb.append("CREATE TABLE ").append(nameTable).append(" (");

            Field[] attributes = cl.getDeclaredFields();

            for (int i = 0; i < attributes.length; i++) {
                Field field = attributes[i];

                String nameColumn;
                String typeColumn = null;

                if (field.isAnnotationPresent(Column.class)) {
                    Column annotationColumn = field.getAnnotation(Column.class);

                    if (annotationColumn.name().isEmpty()) {
                        nameColumn = field.getName().toUpperCase();
                    } else {
                        nameColumn = annotationColumn.name();
                    }
                } else {
                    nameColumn = field.getName().toUpperCase();
                }

                Class<?> typeParemetros = field.getType();

                if (typeParemetros.equals(String.class)) {
                    typeColumn = "VARCHAR(" + field.getAnnotation(Column.class).size() + ")";
                } else if (typeParemetros.equals(int.class)){
                    if (field.getAnnotation(Column.class).pk() == true) {
                        typeColumn = "INT NOT NULL";
                    } else {
                        typeColumn = "INT";
                    }
                } else if (typeParemetros.isEnum()) {
                    typeColumn = "INT";
                }

                if (i > 0) sb.append(",");

                sb.append("\n\t").append(nameColumn).append(" ").append(typeColumn);

                sb.append("\n\tPRIMARY KEY(");

                for (int i = 0, get = 0; i < attributes.length; i++) {
                    Field fields = attributes[i];

                    if (fields.isAnnotationPresent(Column.class)) {
                        Column annotationColumn = field.getAnnotation(Column.class);

                        if (annotationColumn.pk()) {
                            if (get > 0) {
                                sb.append(", ");
                            }

                            if (annotationColumn.name().isEmpty()) {
                                sb.append(fields.getName().toUpperCase());
                            } else {
                                sb.append(annotationColumn.name());
                            }
                            get++;
                        }
                    }
                }
                sb.append(" )");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getDropTable(Object obj) {
        return null;
    }

    @Override
    protected PreparedStatement getSqlInsert(Object obj) {
        return null;
    }

    @Override
    protected PreparedStatement getSqlSelectAll(Object obj) {
        return null;
    }

    @Override
    protected PreparedStatement getSqlSelectById(Object obj) {
        return null;
    }

    @Override
    protected PreparedStatement getSqlUpdateById(Object obj) {
        return null;
    }

    @Override
    protected PreparedStatement getSqlDeleteById(Object obj) {
        return null;
    }
}
