/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.ocweb.grove;

import com.ociweb.gl.api.StartupListener;

import com.ociweb.iot.grove.three_axis_accelerometer_16g.*;
import com.ociweb.iot.maker.FogCommandChannel;
import com.ociweb.iot.maker.FogRuntime;
import static com.ociweb.iot.maker.FogRuntime.*;

/**
 *
 * @author huydo
 */
public class AccelerometerBehavior implements ThreeAxisAccelerometer_16gListener,StartupListener {
    
    //private static final Logger logger = LoggerFactory.getLogger(AccelerometerBehavior.class);
    private final FogCommandChannel c;
    private final ThreeAxisAccelerometer_16g_Facade accSensor;
    
    public AccelerometerBehavior(FogRuntime runtime){
        this.c = runtime.newCommandChannel(I2C_WRITER);
        accSensor = new ThreeAxisAccelerometer_16g_Facade(c,this);
        runtime.registerListener(accSensor);
    }
    
    @Override
    public void startup() {
        accSensor.begin();
        accSensor.setRange(4);
        
    }

    @Override
    public void accelVals(int x, int y, int z) {
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.out.println("z: "+z);
    }

    @Override
    public void act_tapStatus(int byteRead) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void interruptStatus(int byteRead) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
