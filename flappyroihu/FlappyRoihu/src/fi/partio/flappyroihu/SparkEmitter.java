package fi.partio.flappyroihu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleSystem;

/**
 * A stock effect for fire usin the particle system
 *
 * @author kevin
 */
public class SparkEmitter implements ParticleEmitter {
    /** The x coordinate of the center of the fire effect */
    private int x;
    /** The y coordinate of the center of the fire effect */
    private int y;

    /** The particle emission rate */
    private int interval = 24;
    /** Time til the next particle */
    private int timer;
    /** The size of the initial particles */
    private float size = 40;

    private Color color;

    /**
     * Create a default fire effect at 0,0
     */
    public SparkEmitter() {
    }

    /**
     * Create a default fire effect at x,y
     * 
     * @param x The x coordinate of the fire effect
     * @param y The y coordinate of the fire effect
     */
    public SparkEmitter(int x, int y) {
	this.x = x;
	this.y = y;
    }

    /**
     * Create a default fire effect at x,y
     * 
     * @param x The x coordinate of the fire effect
     * @param y The y coordinate of the fire effect
     * @param size The size of the particle being pumped out
     */
    public SparkEmitter(int x, int y, float size, Color color) {
	this.x = x;
	this.y = y;
	this.size = size;
	this.color = color;
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#update(org.newdawn.slick.particles.ParticleSystem, int)
     */
    @Override
    public void update(ParticleSystem system, int delta) {
	timer -= delta;
	if (timer <= 0) {
	    timer = interval;
	    Particle p = system.getNewParticle(this, 1000);
	    //p.setColor(1, 1, 1, 0.5f);
	    p.setColor(color.r, color.g, color.b, color.a);
	    p.setPosition(x, y);
	    p.setSize(size);
	    float vx = (float) (-(Math.random() * 0.15f));
	    float vy = (float) (-0.02f + (Math.random() * 0.04f));
	    p.setVelocity(vx, vy, 1.1f);
	}
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#updateParticle(org.newdawn.slick.particles.Particle, int)
     */
    @Override
    public void updateParticle(Particle particle, int delta) {
	if (particle.getLife() > 600) {
	    particle.adjustSize(0.07f * delta);
	} else {
	    particle.adjustSize(-0.06f * delta * (size / 40.0f));
	}
	float c = 0.002f * delta;
	//particle.adjustColor(0, -c / 2, -c * 2, -c / 4);
	particle.adjustColor(c * 0.10f, c * 0.10f, c * 0.10f, -c * 1.00f);

    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#isEnabled()
     */
    @Override
    public boolean isEnabled() {
	return true;
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#setEnabled(boolean)
     */
    @Override
    public void setEnabled(boolean enabled) {
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#completed()
     */
    @Override
    public boolean completed() {
	return false;
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#useAdditive()
     */
    @Override
    public boolean useAdditive() {
	return false;
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#getImage()
     */
    @Override
    public Image getImage() {
	return null;
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#usePoints(org.newdawn.slick.particles.ParticleSystem)
     */
    @Override
    public boolean usePoints(ParticleSystem system) {
	return false;
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#isOriented()
     */
    @Override
    public boolean isOriented() {
	return false;
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#wrapUp()
     */
    @Override
    public void wrapUp() {
    }

    /**
     * @see org.newdawn.slick.particles.ParticleEmitter#resetState()
     */
    @Override
    public void resetState() {
    }
}
