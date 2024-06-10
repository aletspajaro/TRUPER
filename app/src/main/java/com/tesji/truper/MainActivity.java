package com.tesji.truper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
//import com.tesji.practicasueldo.model.PagoModel;
import com.tesji.truper.model.Sueldo;

public class MainActivity extends AppCompatActivity {
    TextInputEditText txNombre;
    Spinner cmbtipoEmpleado;
    TextInputEditText txHorasT;
    TextInputEditText txCuotaH;
    Button btnCalcular;
    Button btnNuevo;
    Button btnSalir;
    TextView tvImprimir;

    String opcionesTipoEmpleado[]={
            "--Tipo de Empleado--",
            "Tipo 1",
            "Tipo 2",
            "Tipo 3",
            "Tipo 4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txNombre=findViewById(R.id.nombre);
        cmbtipoEmpleado=findViewById(R.id.tipo);
        txHorasT=findViewById(R.id.horas);
        txCuotaH=findViewById(R.id.cuota);
        btnCalcular=findViewById(R.id.alexis_calcular2);
        btnNuevo=findViewById(R.id.alexis_nuevo2);
        btnSalir=findViewById(R.id.alexis_salir2);
        tvImprimir=findViewById(R.id.txvimpresion);

        ArrayAdapter<String> adapterTipoEmpleado = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,opcionesTipoEmpleado);

        cmbtipoEmpleado.setAdapter(adapterTipoEmpleado);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txNombre.setText("");
                txCuotaH.setText("");
                txHorasT.setText("");
                cmbtipoEmpleado.setAdapter(adapterTipoEmpleado);
                tvImprimir.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre;
                String tipoEmpleado;
                int horasTra;
                int cuota;

                nombre=txNombre.getText().toString();
                tipoEmpleado= cmbtipoEmpleado.getSelectedItem().toString();
                horasTra=Integer.parseInt(txHorasT.getText().toString());
                cuota=Integer.parseInt(txCuotaH.getText().toString());



                Sueldo pago = new Sueldo();
                pago.setNombre(nombre);
                pago.setTipoEmpleado(tipoEmpleado);
                pago.setHorasTra(horasTra);
                pago.setCuota(cuota);


                tvImprimir.setText("NOMBRE DE EMPLEADO: "+ nombre
                        +"\nTIPO DE EMPLEADO: "+tipoEmpleado
                        +"\nHORAS TRABAJADAS: "+horasTra
                        +"\nCUOTA QUE SE LE PAGA POR HORA: "+ cuota
                        +"\n "+ pago.CalcularPago());




            }
        });
    }

}