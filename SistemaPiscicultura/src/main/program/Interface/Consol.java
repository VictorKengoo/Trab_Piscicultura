package Interface;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Consol {
    public static void main(String[] args) throws Exception {
        /*TanqueApp tanqueApp = new TanqueApp();
        List<Tanque> listTanque = tanqueApp.getAll(Tanque.class);
        Tanque tanque = new Tanque();
        for (Tanque tank : listTanque) {
            System.out.println(tank);
            if (tank.id == 70) {
                tanque = tank;
            }
        }
        tanqueApp.delete(tanque);*/

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date)formatter.parse("01/29/02");
        System.out.println(date);
        System.out.println(formatter.format(date));

//        Usuario _User = new Usuario();
//        _User.setUsuario("admin10");
//        _User.setSenha("12345678");
//
//        UsuarioApp _usuarioApp = new UsuarioApp();
//        _usuarioApp.Adicionar(_User);
//        System.out.println("AdicionouUsuario");
//
//        LoginApp _loginApp = new LoginApp();
//        _loginApp.doLogin(_User);
//        System.out.println("Logou");
//
//        var userList = _usuarioApp.getAll(Usuario.class);
//        for(Usuario user : userList){
//            System.out.println("User: "+user.getUsuario()+" Senha: "+user.getSenha());
//        }
//        System.out.println("RetornouUsers");
//
//        MonitoramentoApp monApp = new MonitoramentoApp();
//        Monitoramento monitoramento = new Monitoramento();
//        Date data = new Date();
//        monitoramento.setLogData(data);
//        monitoramento.setPh(7.5);
//        monitoramento.setTanqueId(45);
//        monitoramento.setTemperatura(20.5);
//
//        monApp.Adicionar(monitoramento);
//
//
//        PeixeApp _peixeApp = new PeixeApp();
//        Peixe _peixe = new Peixe("OUTRO peixe", 7.5,8.4,9.7,6.5);
//        _peixeApp.Adicionar(_peixe);
//
//        TanqueApp _tanqueApp = new TanqueApp();
//        Tanque _tanque = new Tanque(_peixe, "OK", 20.13);
//        _tanqueApp.Adicionar(_tanque);
//
//
//        Estoque _estoque = new Estoque("Comida1",20);
//        Estoque _estoque2 = new Estoque("Comida2",2116);
//        Estoque _estoque3 = new Estoque("comida3",2020);
//        EstoqueApp _estoqueApp = new EstoqueApp();
//        _estoqueApp.Adicionar(_estoque);
//        _estoqueApp.Adicionar(_estoque2);
//        _estoqueApp.Adicionar(_estoque3);
//        System.out.println("AdicionouEstoque");
//
//        var estoqueList = _estoqueApp.getAll(Estoque.class);
//        for(Estoque est : estoqueList){
//            System.out.println("Marca: "+est.getMarca()+" Qtd: "+est.getQuantidade());
//        }
//        System.out.println("RetornouEstoques");
    }
}


