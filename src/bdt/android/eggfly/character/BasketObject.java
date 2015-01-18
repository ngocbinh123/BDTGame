package bdt.android.eggfly.character;

import java.util.Random;

import org.anddev.andengine.entity.sprite.Sprite;

public class BasketObject {
	public float floatX = 0;
	public float floatY = 0;
	public float velocityX = 0;
	public float velocityY = 0;
	public float gravity = 0.5f;
	public int mode = 0;
	public Sprite mSpriteBasket;
	
	public BasketObject()
	{
		// initial Sprite
		// initial position Basket
	}
	

	//Khởi tạo vị trí và mode
	//Có 3 rổ tương ứng với index={0,1,2}
	public void generatePosition(int index) {
		Random randomGenerator = new Random();
		
		switch (index) {
		case 0:
			this.floatY = 500;
			break;
		case 1:
			this.floatY = 300;
			break;
		default: //2
			this.floatY = 100;
			break;
		}
		 
		mode = randomGenerator.nextInt(2);
		
		switch (mode) {
		case 0: //Đi ngang trái -> phải
			this.floatX = 0;
			break;
		case 1: //Đi ngang phải -> trái
			this.floatX = 400;
			break;
		case 2: //Đi chéo trên -> dưới
			this.floatX = 0;
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		default:
			break;
		}
	}

	// move Basket
	/*
	 * 0: Đi ngang trái -> phải 1: Đi ngang phải -> trái 2: Đi chéo trên -> dưới
	 * 3: Đi chéo dưới -> trên 4: Đi theo hình Sin 5: Đi theo hình Cos 
	 * 6: Đi theo hình Sin ngược 7: Đi theo hình Cos ngược ...
	 */
	public void move() {
		switch (mode) {
			case 0: //Đi ngang trái -> phải
				//y giữ nguyên, x tăng lên
				velocityX = 5;
				floatX = floatX + velocityX;
				break;
			case 1: //Đi ngang phải -> trái
				//y giữ nguyên, x giảm xuống
				velocityX = -5;
				floatX = floatX - velocityX;
				break;
			case 2: //Đi chéo trên -> dưới
				//x tăng, y tăng
				velocityX = 5;
				velocityY = 3;
				floatX = floatX - velocityX;
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			default:
				break;
		}
		
		if (floatX > 480)
			floatX = -100;
	}

	// Reset Position
	// set về vị trí ban đầu - có thể được dùng cho lần kế tiếp
	public void resetPosition() {
		
	}
	
	
}
