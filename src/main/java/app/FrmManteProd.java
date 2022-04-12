package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Productos;
import model.Proovedor;

public class FrmManteProd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox<Categoria> cboCategorias;
	JComboBox<Proovedor> cboProovedor;

	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(175, 366, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox<Categoria>();
		cboCategorias.setBounds(122, 70, 118, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 139, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 136, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 167, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 164, 77, 20);
		contentPane.add(txtPrecio);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultar();
			}
		});
		
		
		btnConsultar.setBounds(324, 63, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton Eliminar = new JButton("Eliminar");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				
			}
		});
		Eliminar.setBounds(324, 97, 89, 23);
		contentPane.add(Eliminar);
		
		JLabel lblNewLabel = new JLabel("Proovedor");
		lblNewLabel.setBounds(10, 106, 86, 14);
		contentPane.add(lblNewLabel);
		
		cboProovedor = new JComboBox<Proovedor>();
		cboProovedor.setBounds(122, 103, 118, 22);
		contentPane.add(cboProovedor);
		
		llenaComboCategoria();
		llenarComboProveedor();
	}

	void llenaComboCategoria() {
        //Fabrica --> DAO
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory ("mysql");
        //MANEJADOR DE ENTIDADES
        EntityManager em = fabrica.createEntityManager();

        //empieza el proceso --> listado --> em.getTransaction().begin

        TypedQuery<Categoria> consulta = em.createQuery("Select c from Categoria c", Categoria.class);
        List<Categoria> lstCategoria = consulta.getResultList();

        for (Categoria c : lstCategoria) {
            cboCategorias.addItem( new Categoria(c.getIdCategoria(), c.getDescripcion()));

        }

        //CIERRE
        em.close();
        

    }
	
	void llenarComboProveedor() {
		//Fabrica --> DAO
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory ("mysql");
				//MANEJADOR DE ENTIDADES
				EntityManager em = fabrica.createEntityManager();
				
				//empieza el proceso --> listado --> em.getTransaction().begin
				
				TypedQuery<Proovedor> consulta = em.createQuery("Select p from Proovedor p", Proovedor.class);
				List<Proovedor> lstProovedor = consulta.getResultList();
				
				for (Proovedor p : lstProovedor) {
					cboProovedor.addItem(new Proovedor(p.getId(), p.getNombre()));
				
				
				//CIERRE
				em.close();
				
					
					
				}	
	}
	
	void listado() {
		txtSalida.setText("");
		//Fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory ("mysql");
		//MANEJADOR DE ENTIDADES
		EntityManager em = fabrica.createEntityManager();
		
		//empieza el proceso --> listado --> em.getTransaction().begin
		
		TypedQuery<Productos> consulta = em.createQuery("Select p from Productos p", Productos.class);
		List<Productos> lstProductos = consulta.getResultList();
		
		for (Productos p : lstProductos) {
			
			txtSalida.append("ID: "+p.getId()+"\n"+
							 "Descripcion: "+p.getDescripcion()+"\n"+
							 "Stock: "+p.getStk()+"\n"+
							 "Precio: "+p.getPrecio()+"\n"+
							 "IdCategoria: "+p.getId_categoria()+"\n"+
							
							 "-----------------------"+"\n");
		}
		
		//CIERRE
		em.close();
		

	}
	
	void registrar() {
		//Creacion del objeto usuario
		Productos prod = new Productos();
		//Asignando valores
		prod.setId(txtCódigo.getText());
		prod.setDescripcion(txtDescripcion.getText());
		prod.setStk(Integer.parseInt(txtStock.getText()));
		prod.setPrecio(Double.parseDouble(txtPrecio.getText()));
		
		//obteniendo los valores del cbo
		Categoria c = (Categoria) cboCategorias.getSelectedItem();
		Proovedor p = (Proovedor) cboProovedor.getSelectedItem();
		
		prod.setId_categoria(c.getIdCategoria());
		prod.setId_proveedor(p.getId());
		prod.setEstado(1);
		
		//Fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory ("mysql");
		//MANEJADOR DE ENTIDADES
		EntityManager em = fabrica.createEntityManager();
				
		try {
			em.getTransaction().begin();
			// REGISTRAR
			em.persist(prod);
			
			em.getTransaction().commit();
			
			mensaje("Producto registrado");
			}	
		catch(Exception ex) {
			System.out.println("Error al registrar...." + ex.getMessage());
			//em.getTransaction().rollback();
		}
		em.close();
		
		
	
	}
	
	void consultar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");		
		EntityManager em = factory.createEntityManager();
		
		Productos u = em.find(Productos.class, txtCódigo.getText());
		
		if(u!=null) {
		txtDescripcion.setText(u.getDescripcion());	
		txtStock.setText(u.getStk()+"");
				
		txtPrecio.setText(""+u.getPrecio());
		mensaje("Producto encontrado");

		}
		else {
			mensaje("Producto no encontrado");
		}
		
	}
	
	void eliminar() {
		//version mejorada de eliminar
		//Fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory ("mysql");
		//MANEJADOR DE ENTIDADES
		EntityManager em = fabrica.createEntityManager();

		// PROCESO
		// forma 1.eliminacion logica --> actualizacion de estados (osea no se elimina de la base de datos)
		// forma 2.eliminacion fisica --> delete o eliminar el registro
		
		String id = txtCódigo.getText();
		

		//select ..... where id
		Productos p = em.find(Productos.class, id);
				
		//devuelve un objeto de entidad, si encuentra el id, sino devuelve null
		if(p==null) {
			mensaje("Producto no existe");
		}
		else {
			//EMPIEZA EL PROCESO
			em.getTransaction().begin();
			//eliminar
			em.remove(p);
			//CONFIRMACION
			em.getTransaction().commit();
			mensaje("Producto eliminado");
		}
		
		//CIERRE
		em.close();
				
				
	}
	
	
	
	void mensaje(String s){
		JOptionPane.showMessageDialog(this, s, "Informacion", 1);
	}
}
