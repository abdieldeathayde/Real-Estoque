package com.estoque.realcar.controller;

import com.estoque.realcar.service.ProdutoService;
<<<<<<< HEAD
import com.estoque.realcar.service.ExcelImportService;
import com.estoque.realcar.dto.ProdutoRequestDTO;
import com.estoque.realcar.dto.ProdutoResponseDTO;
import jakarta.validation.Valid;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
=======
//import com.estoque.realcar.service.ExcelImportService;
import com.estoque.realcar.dto.request.ProdutoRequestDTO;
import com.estoque.realcar.dto.response.ProdutoResponseDTO;
import jakarta.validation.Valid;

//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
>>>>>>> 0dc24ae (hash de senha)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD
import java.io.IOException;
import java.util.List;
import java.util.Map;
=======
import java.util.List;
>>>>>>> 0dc24ae (hash de senha)

@CrossOrigin("*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
<<<<<<< HEAD
    private final ExcelImportService excelImportService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, ExcelImportService excelImportService) {
        this.produtoService = produtoService;
        this.excelImportService = excelImportService;
    }

=======
//    private final ExcelImportService excelImportService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
//        this.excelImportService = excelImportService;
    }


>>>>>>> 0dc24ae (hash de senha)
     @CrossOrigin(origins = "*")
     @RestController
     public class ImportacaoController {
         @PostMapping("/importar")
         public ResponseEntity<String> importar(@RequestParam("file") MultipartFile file) {
              // processamento...
            return ResponseEntity.ok("Importação concluída!");
         }
     }



     @PostMapping("/importar")
     public ResponseEntity<String> importar(@RequestParam("file") MultipartFile file) {
         try {
             // Ler o arquivo com Apache POI
<<<<<<< HEAD
             Workbook workbook = new XSSFWorkbook(file.getInputStream());
             Sheet sheet = workbook.getSheetAt(0);
=======
//             Workbook workbook = new XSSFWorkbook(file.getInputStream());
//             Sheet sheet = workbook.getSheetAt(0);
>>>>>>> 0dc24ae (hash de senha)
             // processar dados...
             return ResponseEntity.ok("Importação concluída!");
         } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Erro ao processar arquivo: " + e.getMessage());
         }
     }


    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@Valid @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO salvo = produtoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO dto) {
        return produtoService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = produtoService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Importa produtos de um arquivo Excel
     * O arquivo deve conter as colunas: Nome, Quantidade, Preço
     */
<<<<<<< HEAD
    @PostMapping("/importar/visualizar")
    public ResponseEntity<?> visualizarImportacao(@RequestParam("file") MultipartFile file) {
        try {
            List<ProdutoRequestDTO> produtos = excelImportService.importarDePlanilha(file);
            return ResponseEntity.ok(Map.of(
                    "total", produtos.size(),
                    "produtos", produtos,
                    "mensagem", "Produtos prontos para importar"
            ));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("erro", "Erro ao ler arquivo: " + e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("erro", e.getMessage()));
        }
    }
=======
//    @PostMapping("/importar/visualizar")
//    public ResponseEntity<?> visualizarImportacao(@RequestParam("file") MultipartFile file) {
//        try {
//            List<ProdutoRequestDTO> produtos = excelImportService.importarDePlanilha(file);
//            return ResponseEntity.ok(Map.of(
//                    "total", produtos.size(),
//                    "produtos", produtos,
//                    "mensagem", "Produtos prontos para importar"
//            ));
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("erro", "Erro ao ler arquivo: " + e.getMessage()));
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("erro", e.getMessage()));
//        }
//    }
>>>>>>> 0dc24ae (hash de senha)

    /**
     * Importa e salva produtos de um arquivo Excel
     * O arquivo deve conter as colunas: Nome, Quantidade, Preço
     */
<<<<<<< HEAD
    @PostMapping("/importar")
    public ResponseEntity<?> importarDePlanilha(@RequestParam("file") MultipartFile file) {
        try {
            int totalImportado = excelImportService.importarESalvar(file);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "sucesso", true,
                            "totalImportado", totalImportado,
                            "mensagem", totalImportado + " produto(s) importado(s) com sucesso"
                    ));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "sucesso", false,
                            "erro", "Erro ao ler arquivo: " + e.getMessage()
                    ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of(
                            "sucesso", false,
                            "erro", e.getMessage()
                    ));
        }
    }
=======
//    @PostMapping("/importar")
//    public ResponseEntity<?> importarDePlanilha(@RequestParam("file") MultipartFile file) {
//        try {
//            int totalImportado = excelImportService.importarESalvar(file);
//            return ResponseEntity.status(HttpStatus.CREATED)
//                    .body(Map.of(
//                            "sucesso", true,
//                            "totalImportado", totalImportado,
//                            "mensagem", totalImportado + " produto(s) importado(s) com sucesso"
//                    ));
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of(
//                            "sucesso", false,
//                            "erro", "Erro ao ler arquivo: " + e.getMessage()
//                    ));
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of(
//                            "sucesso", false,
//                            "erro", e.getMessage()
//                    ));
//        }
//    }
>>>>>>> 0dc24ae (hash de senha)
}

