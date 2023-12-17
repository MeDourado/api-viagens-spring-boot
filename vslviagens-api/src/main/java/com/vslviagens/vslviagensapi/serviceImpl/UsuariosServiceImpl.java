package com.vslviagens.vslviagensapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vslviagens.vslviagensapi.model.Usuarios;
import com.vslviagens.vslviagensapi.repository.UsuariosRepository;
import com.vslviagens.vslviagensapi.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

}
