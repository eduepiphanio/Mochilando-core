/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.util.List;
import model.domain.TagDiario;
import model.excecao.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceTagDiario {
    public Long inserir(TagDiario tagDiario ) throws ExcecaoPersistencia;
    public boolean alterar(TagDiario tagDiario) throws ExcecaoPersistencia;
    public boolean excluir(TagDiario tagDiario) throws ExcecaoPersistencia;
    public TagDiario consultarPorId(Long seqTagDiario) throws ExcecaoPersistencia;
    public List<TagDiario> listarTudo() throws ExcecaoPersistencia;
    public List<TagDiario> listarPorCodDiario(Long codDiario) throws ExcecaoPersistencia;
}
