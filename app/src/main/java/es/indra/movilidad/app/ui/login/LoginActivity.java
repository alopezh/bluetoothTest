package es.indra.movilidad.app.ui.login;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import es.indra.movilidad.R;
import es.indra.movilidad.app.base.BaseActivity;
import es.indra.movilidad.inject.GraphRetriever;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    private LoginPresenter loginPresenter;

    @InjectView(R.id.editTextPassword)
    TextView tvPassword;

    @InjectView(R.id.editTextUser)
    TextView tvUser;

    @InjectView(R.id.buttonValidate)
    Button validateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        loginPresenter = new LoginPresenterImpl(this);
        GraphRetriever.from(this).inject(loginPresenter);
        loginPresenter.onCreate();
        validateButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        loginPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.buttonValidate) {
            loginPresenter.validate(tvUser.getText().toString(), tvPassword.getText().toString());
        }
    }

    @Override
    public void validationOK() {
        Toast.makeText(this, "LOGIN OK", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validationError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
