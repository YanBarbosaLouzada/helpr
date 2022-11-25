package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domen.Chamado;
import org.soulcodeacademy.helpr.domen.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.domen.enums.StatusChamado;
import org.soulcodeacademy.helpr.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ChamadoController {
    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/chamados")
    public List<Chamado> listarChamados(){
        return this.chamadoService.listarChamados();
    }

    @GetMapping("/chamados/{idChamado}")
    public Chamado getChamado(@PathVariable Integer idChamado){
        return this.chamadoService.getChamado(idChamado);
    }

    @PostMapping("/chamados")
    public Chamado salvar(@Valid @RequestBody ChamadoDTO dto) {
        return this.chamadoService.salvar(dto);

    }
    @PutMapping("/Chamados/{idChamado}")
    public Chamado atualizar(@PathVariable Integer idChmado, @Valid @RequestBody ChamadoDTO dto){
        return this.chamadoService.atualizar(idChmado, dto);
    }

    //Listar por cliente
    @GetMapping("/chamados/cliente/ {idCliente}")
    public List<Chamado> listarPorCliente(@PathVariable Integer idCliente){
        return this.chamadoService.listarPorCliente(idCliente);
    }
    @GetMapping("/chamados/funcionario/ {idFuncionario}")
    public List<Chamado> listarPorFuncionario(@PathVariable Integer idFuncionario){
        return this.chamadoService.listarPorFuncionario(idFuncionario);
    }

    // Fazer soma

    @GetMapping("/soma")
    public Integer soma(@RequestParam Integer numero1, @RequestParam Integer numero2){
        return numero1 + numero2;
    }

    //Seleção por status

    @GetMapping("/chamados/status")
    public List<Chamado> listarPorStatus(@RequestParam StatusChamado status){
        return this.chamadoService.listarPorStatus(status);
    }

    //listar por data por intervalo
    @GetMapping("/chamados/intervalo")
    public List<Chamado> listarPorIntervaloDatas
    (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim){
        return this.chamadoService.listarPorIntervaloDatas(inicio, fim);
    }


}
