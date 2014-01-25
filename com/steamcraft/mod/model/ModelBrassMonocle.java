package com.steamcraft.mod.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * 
 * @author MrArcane111
 * @version 2.99999999
 *
 */

public class ModelBrassMonocle extends ModelBiped
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;

	public ModelBrassMonocle(float f)
	{
		super(f, 0, 64, 32);
		//textureWidth = 64;
		//textureHeight = 32;
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape1.setRotationPoint(-4F, -4.5F, -5F);
		//Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 4);
		Shape2.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape2.setRotationPoint(-3F, -5.5F, -5F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape3.setRotationPoint(-1F, -4.5F, -5F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 4);
		Shape4.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape4.setRotationPoint(-3F, -2.5F, -5F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 4, 0);
		Shape5.addBox(0F, 0F, 0F, 1, 1, 0);
		Shape5.setRotationPoint(-4F, -1.5F, -4.5F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 4, 1);
		Shape5.addBox(0F, 0F, 0F, 1, 3, 0);
		Shape5.setRotationPoint(-5F, -0.5F, -4.5F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		
		this.bipedHead.addChild(Shape3);
		this.bipedHead.addChild(Shape1);
		this.bipedHead.addChild(Shape2);
		this.bipedHead.addChild(Shape4);
		this.bipedHead.addChild(Shape5);

	}

	@Override
	public void render(Entity entity, float f1, float f2, float f3, float f4, float f5, float f6)
	{
		super.render(entity, f1, f2, f3, f4, f5, f6);
		this.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
		/*
		Shape1.render(f5);
		Shape2.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape3.render(f5);
		*/
	}

	// Techne method
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity)
	{
		super.setRotationAngles(f1, f2, f3, f4, f5, f6, entity);
	}
}