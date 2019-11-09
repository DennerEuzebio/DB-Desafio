package desafioTestCases;


import org.junit.Test;
import org.junit.runner.RunWith;

import baseTests.BaseCompraProdutoTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import tasks.CompraProdutoFormularioTasks;
import tasks.CompraProdutoTasks;
import utils.CompraProdutoUtils;

@RunWith(JUnitParamsRunner.class)
public class CompraProdutoTestCase extends BaseCompraProdutoTest {

	public CompraProdutoTestCase() {
	}

//	Teste completo sem erros, caminho bonito
	@FileParameters("Massa de dados/Massa de dados testeCompleto.csv")
	@Test
	public void testeCompleto(int item) {
		
		var tasks = new CompraProdutoTasks(driver);
		tasks.acessarSite();
		
//		Verifica se abriu a tela do produto correto
		tasks.clicaProduto(item);
		tasks.validaTelaProduto(item);
		
//		Salva o nome e o preço do produto para comparaçoes futuras
		String nomeProduto = tasks.salvaNomeProduto();
		float precoProduto = tasks.salvaPrecoDoProduto();		
		
//		Salva o produto no carrinho de compras
		tasks.clicaAddToCart();
		tasks.validaCart();;
		
//		Prosegue para a primeira tela do checkout (tela do carrinho de compras)
		tasks.clicaBotaoCheckouJanela();	
		tasks.validaTelaCarrinho();
		
//		Checa o nome está correto no carrinho
		tasks.validaNomeDoProdutoNoCarrinho(tasks.nomeProdutoNoCarrinho(), nomeProduto);
		
//		Prossegue para a segunda tela do checkout (tela de login)
		tasks.clicaBotaoCheckoutCarrinho();
		tasks.validaTelaDeLogin();
		
//		Digita um e-mail aleatorio valido na caixa de e-mail e clica para prosseguir
		var utils = new CompraProdutoUtils(driver, test);
		var stringAleatoria = utils.geraStringlAleatoria();
		tasks.digitaEmail(stringAleatoria+"@teste.com");
		tasks.clicaBotaoCreateAcount();
		tasks.validaTelaDoFormulario();
		
//		Preencher o formulario
		var tasksFormulario = new CompraProdutoFormularioTasks(driver);
		tasksFormulario.selecionaGenero();
		tasksFormulario.digitaNome(utils.geraStringlAleatoria());
		tasksFormulario.digitaSobrenome(utils.geraStringlAleatoria());
		tasksFormulario.digitaSenha(utils.geraStringlAleatoria());
		tasksFormulario.selecionaDiaNascimento(utils.geraInteiroAleatorio(30));
		tasksFormulario.selecionaMesNascimento(utils.geraInteiroAleatorio(11));
		tasksFormulario.selecionaAnoNascimento(utils.geraInteiroAleatorio(118));
		tasksFormulario.digitaCompanhia(utils.geraStringlAleatoria());
		
//		Salva o endereço para comparações futuras
		var endereco = utils.geraStringlAleatoria();
		tasksFormulario.digitaEndereco(endereco);
		var endereco2 = utils.geraStringlAleatoria();
		tasksFormulario.digitaEndereco2(endereco2);
		var cidade = utils.geraStringlAleatoria();
		tasksFormulario.digitaCidade(cidade);
		var estadoSelecionadoIndex = utils.geraInteiroAleatorio(52);
		tasksFormulario.selecionaEstadoPorIndex(estadoSelecionadoIndex);
		var estadoSelecionado = tasksFormulario.salvaEstadoSelecionado();
		var postalCode = utils.geraStringNumerica();
		tasksFormulario.digitaPostCode(postalCode);
		
		tasksFormulario.digitaPhone(utils.geraStringNumerica());
		tasksFormulario.digitaPhoneMobile(utils.geraStringNumerica());
		tasksFormulario.clicaBotaoRegister();
		
		
//		Valida os enderecos
		tasks.validaTelaEnderecos();
		tasks.validaEndereco(endereco, endereco2);
		tasks.validaEndereco2(cidade, estadoSelecionado, postalCode);
		tasks.clicaBotaoCheckoutEnderecos();
		
//		Tela de entrega 
		tasks.validaTelaEntrega();
		var precoEntrega = tasks.salvaPrecoEntrega();
		tasks.clicaCheckboxTermo();
		tasks.clicaBotaoCheckoutEntrega();
		
//		Tela de pagamento
		tasks.validaTelaPagamento();
		tasks.validaPrecoFinal(precoProduto, precoEntrega);
		tasks.clicaBotaoPagamentoTransferecia();
		
//		Tela de confirmacao de compra
		tasks.validaTelaConfirmaPagamento();
		tasks.clicaBotaoCheckoutConfirmaPagamento();
		
		
		
	}
	
	
//	Teste do formulario.
	@FileParameters("Massa de dados/Massa de dados formulario.csv")
	@Test
	public void testeFormulario(String nome, String sobreNome, String senha, int dia, int mes, int ano,
			String companhia, String endereco1, String endereco2, String cidade, int estado, String postalCode,
			String phone, String mobile) {
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication");
		
		var tasks = new CompraProdutoTasks(driver);
		var utils = new CompraProdutoUtils(driver, test);
		var tasksFormulario = new CompraProdutoFormularioTasks(driver);
		tasks.digitaEmail(utils.geraStringlAleatoria()+"@teste.com");
		tasks.clicaBotaoCreateAcount();
		tasks.validaTelaDoFormulario();
		tasksFormulario.selecionaGenero();
		tasksFormulario.digitaNome(nome);
		tasksFormulario.digitaSobrenome(sobreNome);
		tasksFormulario.digitaSenha(senha);
		tasksFormulario.selecionaDiaNascimento(dia);
		tasksFormulario.selecionaMesNascimento(mes);
		tasksFormulario.selecionaAnoNascimento(ano);
		tasksFormulario.digitaCompanhia(companhia);
		tasksFormulario.digitaEndereco(endereco1);
		tasksFormulario.digitaEndereco2(endereco2);
		tasksFormulario.digitaCidade(cidade);
		tasksFormulario.selecionaEstadoPorIndex(estado);
		tasksFormulario.digitaPostCode(postalCode);
		tasksFormulario.digitaPhone(phone);
		tasksFormulario.digitaPhoneMobile(mobile);
		tasksFormulario.clicaBotaoRegister();
		utils.geraRelatorioFormulario(nome);
		tasksFormulario.validaUrlMinhaConta();

	}
	
}
