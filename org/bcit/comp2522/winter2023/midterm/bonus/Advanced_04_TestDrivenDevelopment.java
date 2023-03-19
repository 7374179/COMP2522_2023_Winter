package org.bcit.comp2522.winter2023.midterm.bonus;

public class Advanced_04_TestDrivenDevelopment {
  // Advanced Question 04 (20 points, 4 TODOs)
  // Idea: tests your ability to design with test cases.

  // README FIRST
  // I will ONLY be reading from this package:
  //   org.bcit.comp2522.winter2023.midterm.answers
  //
  // TODO 0: Create a copy of this file in the answers package.
  // Put your answers in new classes that are labeled with the
  // question label, e.g., Advanced_04_myClass. Name them something
  // useful, other than "myClass", that is just an example.

  // TODO 1: Imagine that you are asked to create a BouncingBall class
  // that bounces off of the Ground class. The BouncingBall class has
  // position, velocity, and acceleration. The Ground class has bounds
  // and a gravity attribute. Create the test cases for this class.
  // The high-level things that you want it to accomplish are the following:
  // - The ball falls at a rate of v_next = v_prev + acc;
  // - a bounce reverses the direction of travel
  // - The ball bounces on the edge of the ball, not the centroid
  // - every bounce takes the ball to half the height of the previous

  // Note that you may need more than one test case per requirement.
  // Also note that you do NOT need to write the logic for these functions,
  // just create the test coverage.

//    private BouncingBall ball;
//    private Ground ground;
//
//    @BeforeEach
//    void setUp() {
//        ball = new BouncingBall(10, 50, 20, 0, -9.81);
//        ground = new Ground(0, 0, 500, 0, -9.81);
//    }
//
//    @Test
//    void testBallFallsAtRateOfAcceleration() {
//        ball.updatePosition();
//        assertEquals(40, ball.getPosition(), 0.01);
//    }
//
//    @Test
//    void testBallBouncesOffGround() {
//        ball.setVelocity(-20);
//        ball.updatePosition();
//        assertEquals(20, ball.getPosition(), 0.01);
//    }
//
//    @Test
//    void testBallBouncesOnEdge() {
//        ball.setPosition(5);
//        ball.setVelocity(-20);
//        ball.updatePosition();
//        assertEquals(15, ball.getPosition(), 0.01);
//    }
//
//    @Test
//    void testBallBouncesToHalfHeight() {
//        ball.setVelocity(-20);
//        ball.updatePosition();
//        assertEquals(20, ball.getPosition(), 0.01);
//        ball.updatePosition();
//        assertEquals(15, ball.getPosition(), 0.01);
//    }
//
//    @Test
//    void testMultipleBounces() {
//        ball.setVelocity(-20);
//        ball.updatePosition();
//        assertEquals(20, ball.getPosition(), 0.01);
//        ball.updatePosition();
//        assertEquals(15, ball.getPosition(), 0.01);
//        ball.updatePosition();
//        assertEquals(17.5, ball.getPosition(), 0.01);
//        ball.updatePosition();
//        assertEquals(16.25, ball.getPosition(), 0.01);
//    }
//
}
