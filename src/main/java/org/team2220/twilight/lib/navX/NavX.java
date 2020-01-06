package org.team2220.twilight.lib.navX;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;

/**
 * navX motion processor "subsystem." Acts as a static class using an internal
 * singleton.
 * 
 * This class is not fully-featured or considered complete. It is built around
 * the official navX docs referenced below.
 * 
 * @author Reece
 * @see {@link https://www.kauailabs.com/public_files/navx-mxp/apidocs/java/}
 */
public class NavX {

    // NavX Object, default port on roboRIO
    private AHRS navX = new AHRS(SPI.Port.kMXP);

    // Single instance of this class
    private static NavX instance;

    // Create a private-only constructor
    private NavX() {
    }

    /**
     * Private method to get the instance and handle the existance of the instance.
     * 
     * @return Returns the only instance of this class.
     */
    private static NavX getInstance() {
        if (instance == null) {
            instance = new NavX();
        }
        return instance;
    }

    /**
     * Method to simplify accessing the navX board instance member from singleton.
     * 
     * @return Returns navX board instance member.
     */
    private static AHRS getMotion() {
        return getInstance().navX;
    }

    /**
     * Sets the port of the navX.
     * 
     * @param port The port in which the navX is located.
     */
    public static void setPort(SPI.Port port) {
        getInstance().navX = new AHRS(port);
    }

    /**
     * Method to read the current heading from the navX.
     * 
     * @return Tthe current heading of the navX. Range: (-180, 180) degrees.
     */
    public static float getHeading() {
        return getMotion().getYaw();
    }

    /**
     * Method to read the rate of change of the heading from the NavX.
     * 
     * @return The velocity of the heading of the navX in degrees/sec.
     */
    public static double getHeadingRate() {
        return getMotion().getRate();
    }

    /**
     * Method to access the total accumulated angle of the navX. This has no range
     * and counts over-rotations.
     * 
     * @return The total accumulated heading of the navX in degrees
     */
    public static double getAccumulatedAngle() {
        return getMotion().getAngle();
    }

    /**
     * Method to access the current X-axis acceleration read from the navX. This
     * linear acceleration accounts for forward-backward movement.
     * 
     * @return The current linear X-axis acceleration of the navX in Gs.
     */
    public static float getXAccel() {
        return getMotion().getWorldLinearAccelX();
    }

    /**
     * Method to access the current Y-axis acceleration read from the navX. This
     * linear acceleration accounts for left-right movement.
     * 
     * @return The current linear Y-axis acceleration of the navX in Gs.
     */
    public static float getYAccel() {
        return getMotion().getWorldLinearAccelY();
    }

    /**
     * Method to access the current Z-axis acceleration read from the navX. This
     * linear acceleration accounts for up-down movement.
     * 
     * @return The current linear Z-axis acceleration of the navX in Gs.
     */
    public static float getZAccel() {
        return getMotion().getWorldLinearAccelZ();
    }

    /**
     * Method to effectively "zero" the yaw, or heading. It sets the adjusted angle
     * to the current heading, reading any angle change from 0. This does not truly
     * zero the sensor, but is the safer option to use during motion.
     */
    public static void zeroYaw() {
        getMotion().zeroYaw();
    }

    /**
     * Method to truly zero the yaw, or heading. It recalibrates the yaw sensor
     * resetting any heading angle measurements. Use this method before or after
     * motion, as there may be a pause between sensor reads while the sensor
     * recalibrates.
     */
    public static void recalibrateYaw() {
        getMotion().reset();
    }
}