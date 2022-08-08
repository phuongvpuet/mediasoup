package org.mediasoup.droid.demo;

import static org.mediasoup.droid.lib.Utils.getRandomString;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.mediasoup.droid.demo.databinding.ActivityGreetingBinding;
import org.mediasoup.droid.demo.databinding.ContentGreetingBinding;

public class GreetingActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ContentGreetingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ContentGreetingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.url.getEditText().setText("portal-mediasoup-dev.service.zingplay.com");
//        binding.url.getEditText().setText("v3demo.mediasoup.org");
        binding.port.getEditText().setText("4443");
        binding.roomId.getEditText().setText("zps");
        binding.name.getEditText().setText("Ahihihi" + getRandomString(8));
        binding.button.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View view){
            onClickButton(view);
          }
        });
    }
    private void onClickButton(View view){
      Intent intent = new Intent(this, RoomActivity.class);
      intent.putExtra("url", binding.url.getEditText().getText().toString());
      intent.putExtra("port", binding.port.getEditText().getText().toString());
      intent.putExtra("roomId", binding.roomId.getEditText().getText().toString());
      intent.putExtra("name", binding.name.getEditText().getText().toString());
      startActivity(intent);
    }
}
