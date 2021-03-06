/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.util.List;
import model.domain.Dia;
import model.excecao.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceDiaDAO {
    public Long inserir(Dia dia) throws ExcecaoPersistencia;
    public boolean alterar(Dia dia) throws ExcecaoPersistencia;
    public boolean excluir(Dia dia) throws ExcecaoPersistencia;
    public Dia consultarDiaPorId(Long seqDia) throws ExcecaoPersistencia;
    public List<Dia> listarPorCodDiario(Long codDiario) throws ExcecaoPersistencia; 
}
