package escola.dao;

public class DaoFactory {
    
    public static AlunoDao getAlunoDao(){
        return new AlunoDao();
    }
    public static MatriculaDao getMatriculaDao(){
        return new MatriculaDao();
    }
    public static TurmaDao getTurmaDao(){
        return new TurmaDao();
    }
    
}