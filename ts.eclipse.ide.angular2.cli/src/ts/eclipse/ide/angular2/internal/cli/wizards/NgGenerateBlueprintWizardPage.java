package ts.eclipse.ide.angular2.internal.cli.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ts.eclipse.ide.angular2.cli.NgBlueprint;
import ts.eclipse.ide.angular2.internal.cli.AngularCLIMessages;

public class NgGenerateBlueprintWizardPage extends WizardPage {

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private final NgBlueprint blueprint;
	private Text resourceNameField;
	private final IProject project;

	private Text projectField;

	protected NgGenerateBlueprintWizardPage(String pageName, String title, ImageDescriptor titleImage,
			NgBlueprint blueprint, IProject project) {
		super(pageName, title, titleImage);
		this.blueprint = blueprint;
		this.project = project;
	}

	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		// top level group
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());

		createNameControl(topLevel);

		validatePage();
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(topLevel);
	}

	private void createNameControl(Composite parent) {
		Font font = parent.getFont();
		// resource name group
		Composite nameGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		nameGroup.setLayout(layout);
		nameGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		nameGroup.setFont(font);

		// Project
		Label label = new Label(nameGroup, SWT.NONE);
		label.setText(AngularCLIMessages.NgGenerateBlueprintWizardPage_projectName);
		label.setFont(font);

		projectField = new Text(nameGroup, SWT.BORDER);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		projectField.setLayoutData(data);
		projectField.setFont(font);
		projectField.setText(project != null ? project.getName() : "");

		// Blueprint name
		label = new Label(nameGroup, SWT.NONE);
		label.setText(AngularCLIMessages.NgGenerateBlueprintWizardPage_bluePrintName);
		label.setFont(font);

		// resource name entry field
		resourceNameField = new Text(nameGroup, SWT.BORDER);
		// resourceNameField.addListener(SWT.Modify, this);
		// resourceNameField.addFocusListener(new FocusAdapter() {
		// public void focusLost(FocusEvent e) {
		// handleResourceNameFocusLostEvent();
		// }
		// });
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		resourceNameField.setLayoutData(data);
		resourceNameField.setFont(font);
		// validateControls();

	}

	protected boolean validatePage() {
		boolean valid = true;

		return valid;
	}

	public IProject getProject() {
		return project;
	}

	public NgBlueprint getNgBluePrint() {
		return blueprint;
	}

	public String getBluepringName() {
		// TODO Auto-generated method stub
		return resourceNameField.getText();
	}

}
