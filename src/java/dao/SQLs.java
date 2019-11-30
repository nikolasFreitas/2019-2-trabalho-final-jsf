package dao;

public enum SQLs {
    INSERT_IMOVEL("insert into imovel(matricula, endereco, valorVenda) values (?, ?, ?)"), 
    LISTALL_IMOVEL("select * from imovel"),
    DELETE_IMOVEL("delete from imovel where id=? "),
    UPDATE_IMOVEL("update imovel set endereco=?, valorVenda=? where id=?"),
    FINDID_IMOVEL("select * from imovel where id=? or matricula=?"),

    FINDID_USER("select * from usuario where identificador=? and senha=?");
  
    private final String sql;
    SQLs(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }    
}

