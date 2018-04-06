scala methods are public by default
provides the following scope options:
 1) object-private scope: 
   method is available only to the current instance of the current object
   other instances of the same class cannot access the method
   syntax: private[this] def isFoo = true
   Eg:
     class Foo {
       private[this] def isFoo = true // 1) object-private scope
       private def isFoo = true // 1) private scope

       def doFoo(other: Foo) {
         if (other.isFoo) { // 1) this line wont compile
                            // 2) this line compiles
         // ...
         }
       }
     }

 2) private
   method available to the current class and other instances of the current class
   tis is not available to subclasses
 
 3) protected
   method available to the subclasses
   Eg:
     class Animal {
       protected def breathe {}
     }
     class Dog extends Animal {
       breathe
     }
     
   Java: methodscab be accessed by other classes in the same package, but this isn't true in scala
   Eg:
     package world {
       
       class Animal {
         protected def breathe {}
       }
       class Jungle {
         val a = new Animal
         a.breathe  // error: this line won't compile
       }

     }
 4) package
   method available to all members of the current package
   syntax: private[packageName]

   Eg:
     package com.acme.coolapp.model {
       
       class Foo {
         private[model] def doX {}
         private def doY {}
       }

       class Bar {
         val f = new Foo
         f.doX // compiles
         f.doY // won't compile
       }

     }

 5) package-specific
   method available at different levels in a class hierarchy

   Eg:
     package com.acme.coolapp.model {
       
       class Foo {
         private[model] def doX {}
         private[coolapp] def doY {}
         private[acme] def doZ {}
       }
     }

     import com.acme.coolapp.model._
     package com.acme.coolapp.view {
       class Bar {
         val f = new Foo
         f.doX // won't compile
         f.doY
         f.doZ
       }
     }
     package com.acme.common{
       class Bar {
         val f = new Foo
         f.doX // won't compile
         f.doY // won't compile
         f.doZ
       }
     }

 6) public
    any class in any package can access the doX method

private[this]       method is available only to the current instance of the class it’s declared in.
private             method is available to the current instance and other instances of the class it’s declared in. 
protected           method is available only to instances of the current class and subclasses of the current class.
private[model]      method is available to all classes beneath the com.acme.coolapp.model package.
private[coolapp]    method is available to all classes beneath the com.acme.coolapp package.
private[acme]       method is available to all classes beneath the com.acme package.
(no modifier)       method is public.
