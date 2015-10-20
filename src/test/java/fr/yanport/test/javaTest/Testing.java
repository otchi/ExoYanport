package fr.yanport.test.javaTest;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import fr.yanport.test.coordonates.GridCoordonate;
import fr.yanport.test.guides.Guide;
import fr.yanport.test.guides.NEWS_DGA_RectangleGrideGuide;
import fr.yanport.test.loader.InstructionLoader;
import fr.yanport.test.loader.SimpleFileInstructionLoader;
import fr.yanport.test.shapes.Rectangle;
import fr.yanport.test.shapes.Shape;
import fr.yanport.test.utils.NEWS_Direction;


public class Testing  {
	@Test
	public void GlobalTest1() throws Exception {
		// TODO Auto-generated method stub
		Guide g = Guide.getGuide(new Rectangle(10, 10), new GridCoordonate(), Guide.NEWS_GDA_System, "0 0 N");
		Assert.assertEquals(g.getClass(), NEWS_DGA_RectangleGrideGuide.class);
		System.out.println(g);
		g.executeInstruction("ADAGA");
		Assert.assertEquals(NEWS_DGA_RectangleGrideGuide.class.cast(g).getDirection(), NEWS_Direction.NORTH);
		System.out.println(g);
	}
	
	@Test
	public void TestWithFileAccess() throws Exception{

		System.out.println("----------------- with file---------------------------------------------");		
		
		InstructionLoader il=new SimpleFileInstructionLoader(new File(
									this.getClass()
										.getClassLoader()
										.getResource("instruction_data/instruction_file")
										.getPath()));
		Guide g=Guide.getGuide(
					Shape.createShape(il.getShapeDefinition(), Rectangle.class), 
					new GridCoordonate(),
					Guide.NEWS_GDA_System,
					il.getInitPosition());
		
		System.out.println(g);
		
		g.executeInstruction(il.getInstructions());
		
		System.out.println(g);
		
		System.out.println("----------------- end with file---------------------------------------------");	
		
	
	}

}
