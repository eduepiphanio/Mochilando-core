/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.util.List;
import model.domain.Tag;
import model.excecao.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceTagDAO {
    public Long inserir(Tag tag) throws ExcecaoPersistencia;
    public boolean alterar(Tag tag) throws ExcecaoPersistencia;
    public boolean excluir(Tag tag) throws ExcecaoPersistencia;
    public Tag consultarTagPorId(Long codTag) throws ExcecaoPersistencia;
    public Tag consultarTagPorNome(String descTag) throws ExcecaoPersistencia;
    public List<Tag> listarTudo() throws ExcecaoPersistencia;
}
