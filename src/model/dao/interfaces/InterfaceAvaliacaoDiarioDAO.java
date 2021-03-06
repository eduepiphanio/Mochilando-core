/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.util.List;
import model.domain.AvaliacaoDiario;
import model.excecao.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceAvaliacaoDiarioDAO {
    public Long inserir(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia;
    public boolean alterar(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia;
    public boolean remover(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia;
    public int consultarNumAvPositivas(Long codDiario) throws ExcecaoPersistencia;
    public int consultarNumAvNegativas(Long codDiario) throws ExcecaoPersistencia;
    public boolean haAvaliacao(Long codUsuario, Long codDiario) throws ExcecaoPersistencia;
    public AvaliacaoDiario consultar(Long codUsuario, Long codDiario) throws ExcecaoPersistencia;
    public List<AvaliacaoDiario> listarPorDiario(Long codDiario) throws ExcecaoPersistencia;
}
