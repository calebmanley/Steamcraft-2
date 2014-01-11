package com.steamcraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelLightningRod extends ModelBase
{
	ModelRenderer Shape2;
	ModelRenderer Shape1;
	ModelRenderer Shape3;
	//ModelRenderer Shape3;
	ModelRenderer Shape4;
	//ModelRenderer Shape4;
	ModelRenderer Shape5;
	//ModelRenderer Shape5;
	ModelRenderer Shape6;
	//ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	//ModelRenderer Shape9;
	//ModelRenderer Shape9;
	//ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;

	public ModelLightningRod()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape2 = new ModelRenderer(this, 0, 18);
		Shape2.addBox(0F, 0F, 0F, 2, 14, 2);
		Shape2.setRotationPoint(-1F, 10F, -1F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 28, 0);
		Shape1.addBox(0F, 0F, 0F, 6, 6, 6);
		Shape1.setRotationPoint(-3F, 8F, -3F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 13, 0);
		Shape3.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape3.setRotationPoint(-1F, 10F, 3F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 13, 7);
		Shape3.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape3.setRotationPoint(-1F, 10F, -4F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 12);
		Shape4.addBox(0F, 0F, 0F, 1, 2, 2);
		Shape4.setRotationPoint(3F, 10F, -1F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 57, 0);
		Shape4.addBox(0F, 0F, 0F, 1, 2, 2);
		Shape4.setRotationPoint(-4F, 10F, -1F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 15, 19);
		Shape5.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape5.setRotationPoint(-0.5F, 10.5F, -7F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 10, 12);
		Shape5.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape5.setRotationPoint(-0.5F, 10.5F, 4F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 25, 20);
		Shape6.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape6.setRotationPoint(4F, 10.5F, -0.5F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		this.setRotation(Shape6, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 20, 27);
		Shape6.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape6.setRotationPoint(-7F, 10.5F, -0.5F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		this.setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 34, 15);
		Shape7.addBox(0F, 0F, 0F, 2, 1, 2);
		Shape7.setRotationPoint(-1F, 7F, -1F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		this.setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 35);
		Shape8.addBox(0F, 0F, 0F, 1, 7, 1);
		Shape8.setRotationPoint(-0.5F, 0F, -0.5F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		this.setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 45);
		Shape9.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape9.setRotationPoint(2.1F, 8F, -3.1F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		this.setRotation(Shape9, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 45);
		Shape9.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape9.setRotationPoint(2.1F, 8F, 2.1F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		this.setRotation(Shape9, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 45);
		Shape9.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape9.setRotationPoint(-3.1F, 8F, 2.1F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		this.setRotation(Shape9, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 45);
		Shape9.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape9.setRotationPoint(-3.1F, 8F, -3.1F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		this.setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 0, 5);
		Shape10.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape10.setRotationPoint(1F, 20F, -5F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		this.setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 0, 0);
		Shape11.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape11.setRotationPoint(0.5F, 20F, -5.5F);
		Shape11.setTextureSize(64, 32);
		Shape11.mirror = true;
		this.setRotation(Shape11, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape2.render(f5);
		Shape1.render(f5);
		Shape3.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape9.render(f5);
		Shape9.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}