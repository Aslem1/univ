import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alain BOUJU
 *
 */
public class TPPanel extends Panel {
	TPClient main = null;
	Button bDroit, bGauche, bHaut, bBas;

	public TPPanel(TPClient pTPClient) {
		this.main = pTPClient;
		// Button Droit
		bDroit = new Button("Droit");
		bDroit.addActionListener(new ListenBoutonDroit());
		this.add(bDroit);
		// Button Gauche
		bGauche = new Button("Gauche");
		bGauche.addActionListener(new ListenBoutonGauche());
		this.add(bGauche);
		// Button Haut
		bHaut = new Button("Haut");
		bHaut.addActionListener(new ListenBoutonHaut());
		this.add(bHaut);
		// Button Gauche
		bBas = new Button("Bas");
		bBas.addActionListener(new ListenBoutonBas());
		this.add(bBas);
	}

	class ListenBoutonDroit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			main.droit();
		}
	}

	class ListenBoutonGauche implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			main.gauche();
		}
	}

	class ListenBoutonHaut implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			main.haut();
		}
	}

	class ListenBoutonBas implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			main.bas();
		}
	}
}
