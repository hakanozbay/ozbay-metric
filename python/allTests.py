import unittest

if __name__ == '__main__':
	testsuite = unittest.TestLoader().discover('test', '*.py')
	
	unittest.TextTestRunner().run(testsuite)
    