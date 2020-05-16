/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDAO {
    public String gravarAluno(Aluno aluno){
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement  stmt = con.createStatement();
            String sql = "INSERT INTO dados (rgm, nome, nota1, nota2)";
            sql += "VALUES ('"+aluno.getRgm()+"', '"+aluno.getNome()+"', "+aluno.getN1()+", "+aluno.getN2()+")";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Aluno cadastrado!";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    public String alterarAluno(Aluno aluno, boolean newRgm, int novoRGM){
                
        String resp = "";
        String sql = "";
        try {
            Connection con = Conecta.getConexao();
            Statement  stmt = con.createStatement();
            if(newRgm){
                sql = "UPDATE DADOS";
                sql += " SET RGM = "+novoRGM+", NOME = '"+aluno.getNome()+"',  nota1 = "+aluno.getN1()+",  nota2 = "+aluno.getN2();
                sql += " WHERE RGM = "+aluno.getRgm();
            }else{
                sql = "UPDATE DADOS";
                sql += " SET RGM = "+aluno.getRgm()+", NOME = '"+aluno.getNome()+"',  nota1 = "+aluno.getN1()+",  nota2 = "+aluno.getN2();
                sql += " WHERE RGM = "+aluno.getRgm();
            }
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Cadastro atualizado!";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
        public String deletarAluno(int rgm){
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement  stmt = con.createStatement();
            String sql = "DELETE FROM DADOS WHERE RGM = " +rgm;
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "Cadastro deletado!";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
        
        public Aluno selecionarAluno(int rgm){
        
            String resp = "";
            Aluno a = new Aluno();
        try {
            Connection con = Conecta.getConexao();
            Statement  stmt = con.createStatement();
            String sql = "SELECT * FROM DADOS WHERE RGM = "+rgm;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
               // System.out.println(rs.getRow());
                a.setRgm(String.valueOf(rs.getInt("rgm")));
                a.setNome(rs.getString("nome"));
                a.setN1(rs.getFloat("nota1"));
                a.setN2(rs.getFloat("nota2"));
            }
            stmt.close();
            con.close();
            resp = "";
        } catch (Exception e) {
            resp = e.toString();
        }
        return a;    
            
    }
        public boolean verificaCadastro(int rgm){
            int row = 0;
            String resp = "";
            try {
                Connection con = Conecta.getConexao();
                Statement  stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DADOS WHERE RGM = "+rgm);
                while(rs.next()){
                    row = rs.getRow();
                }
                stmt.close();
                con.close();
                resp = "";
            }catch (Exception e) {
                resp = e.toString();
            }if(row != 0){
                return false;
            }else{
                return true;
            }
        }
        public boolean verificaCadastroUpdate(int rgm){
            int row = 0;
            int rgmCadastrado = 0;
            String resp = "";
            try {
                Connection con = Conecta.getConexao();
                Statement  stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DADOS WHERE RGM = "+rgm);
                while(rs.next()){
                    row = rs.getRow();
                    rgmCadastrado = rs.getInt("RGM");
                }
                stmt.close();
                con.close();
                resp = "";
            }catch (Exception e) {
                resp = e.toString();
            }if(row != 0){
                return true;
            }else{
                if(rgm == rgmCadastrado){
                    return true;
                }else{
                    return false;
                }
            }
        }
        
        public ArrayList<Aluno> selecionarTodos(){
            
            ArrayList lista = new ArrayList();
            String resp = "";     
        try {
            Connection con = Conecta.getConexao();
            Statement  stmt = con.createStatement();
            String sql = "SELECT * FROM DADOS ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Aluno a = new Aluno();
                a.setRgm(String.valueOf(rs.getInt("rgm")));
                a.setNome(rs.getString("nome"));
                a.setN1(rs.getFloat("nota1"));
                a.setN2(rs.getFloat("nota2"));
                lista.add(a);
            }
            stmt.close();
            con.close();
            resp = "";
        } catch (Exception e) {
            lista = null;
        }
        return lista;    
            
    }
        
}
