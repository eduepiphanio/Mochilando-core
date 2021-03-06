/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author Juliana
 */
public class UsuarioTag {
    private Long seqUsuarioPreferencia;
    private Usuario usuario;
    private Tag tag;

    public UsuarioTag() {
    }

    public UsuarioTag(Long seqUsuarioPreferencia, Usuario usuario, Tag preferencia) {
        this.seqUsuarioPreferencia = seqUsuarioPreferencia;
        this.usuario = usuario;
        this.tag = tag;
    }

    public Long getSeqUsuarioPreferencia() {
        return seqUsuarioPreferencia;
    }

    public void setSeqUsuarioPreferencia(Long seqUsuarioPreferencia) {
        this.seqUsuarioPreferencia = seqUsuarioPreferencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    
}
