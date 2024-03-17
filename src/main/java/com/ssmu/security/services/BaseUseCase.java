package com.ssmu.security.services;

 public interface BaseUseCase<I, R> {
  /// Method to be executed by current use case.
  ///
  /// Should be the only public method
  public R call(I data);
}
